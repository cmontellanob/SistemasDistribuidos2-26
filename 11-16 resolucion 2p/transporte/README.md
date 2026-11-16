# Transporte — API de salidas y asientos (Laravel 12)

--

## 1. Puesta en marcha

```bash
composer install                  
copy .env.example .env            
php artisan key:generate

php artisan migrate:fresh --seed  # crea las tablas y carga datos de prueba
php artisan serve                 # http://localhost:8000
```

Configuración de base de datos en `.env` (XAMPP por defecto):

```env
DB_CONNECTION=mysql
DB_HOST=127.0.0.1
DB_PORT=3306
DB_DATABASE=bd_transporte
DB_USERNAME=root
DB_PASSWORD=
```

---

## 2. Comandos Artisan usados

### Crear modelo + migración + seeder + factory + controlador

Un solo comando crea todo:

```bash
php artisan make:model Salida  -mfsc
php artisan make:model Asiento -mfsc
```

| Opción | Qué crea | Ubicación |
|---|---|---|
| (sin opción) | Modelo | `app/Models/Salida.php` |
| `-m` / `--migration` | Migración | `database/migrations/xxxx_create_salidas_table.php` |
| `-f` / `--factory` | Factory | `database/factories/SalidaFactory.php` |
| `-s` / `--seed` | Seeder | `database/seeders/SalidaSeeder.php` |
| `-c` / `--controller` | Controlador | `app/Http/Controllers/SalidaController.php` |

### Controlador para API (con los 5 métodos REST ya creados)

Agregando `--api` el controlador sale con `index`, `store`, `show`, `update` y `destroy`
(sin `create` ni `edit`, que son formularios web):

```bash
php artisan make:model Salida  -mfsc --api
php artisan make:model Asiento -mfsc --api

```bash
php artisan make:controller SalidaController --api --model=Salida
```

Y se registra en `routes/api.php` con una sola línea:

```php
Route::apiResource('salidas', SalidaController::class);
Route::apiResource('asientos', AsientoController::class);
```

| Verbo | URI | Método |
|---|---|---|
| GET | `/api/salidas` | index |
| POST | `/api/salidas` | store |
| GET | `/api/salidas/{salida}` | show |
| PUT/PATCH | `/api/salidas/{salida}` | update |
| DELETE | `/api/salidas/{salida}` | destroy |

### Habilitar rutas API
```
php artisan install:api   # crea routes/api.php e instala Sanctum
```


### Otros comandos útiles

```bash
php artisan migrate                 # ejecuta migraciones pendientes
php artisan migrate:fresh --seed    # borra todo, migra y ejecuta seeders
php artisan migrate:rollback        # deshace el último lote
php artisan migrate:status          # estado de cada migración
php artisan db:seed --class=SalidaSeeder
php artisan route:list --path=api   # lista las rutas de la API
php artisan tinker                  # consola para probar modelos
php artisan config:clear            # limpiar caché tras cambiar 
---

## Tipos de datos en migraciones

Se definen dentro de `Schema::create('tabla', function (Blueprint $table) { ... })`.

### Tipos de columna más usados

| Método | Tipo en MySQL | Uso típico |
|---|---|---|
| `$table->id()` | BIGINT UNSIGNED AUTO_INCREMENT PK | Clave primaria |
| `$table->string('nombre', 100)` | VARCHAR(100) (255 por defecto) | Textos cortos: nombre, destino, placa, CI |
| `$table->text('descripcion')` | TEXT | Textos largos |
| `$table->integer('cantidad')` | INT | Enteros con signo |
| `$table->unsignedInteger('capacidad')` | INT UNSIGNED | Enteros ≥ 0 |
| `$table->tinyInteger('nivel')` | TINYINT | Enteros pequeños |
| `$table->bigInteger('valor')` | BIGINT | Enteros grandes |
| `$table->decimal('precio', 8, 2)` | DECIMAL(8,2) | **Dinero** (exacto) |
| `$table->float('peso')` / `double()` | FLOAT / DOUBLE | Medidas aproximadas (no para dinero) |
| `$table->boolean('activo')` | TINYINT(1) | Verdadero / falso |
| `$table->date('fecha')` | DATE | Solo fecha (`2026-11-16`) |
| `$table->time('hora')` | TIME | Solo hora (`14:30:00`) |
| `$table->dateTime('salida_en')` | DATETIME | Fecha y hora |
| `$table->timestamp('pagado_en')` | TIMESTAMP | Fecha y hora (UTC) |
| `$table->timestamps()` | `created_at`, `updated_at` | Auditoría automática |
| `$table->softDeletes()` | `deleted_at` | Borrado lógico |
| `$table->enum('estado', ['libre','vendido'])` | ENUM | Lista cerrada de valores |
| `$table->json('datos')` | JSON | Datos estructurados |
| `$table->uuid('codigo')` | CHAR(36) | Identificadores únicos |

### Modificadores

```php
$table->string('email')->unique();           // valor único
$table->string('telefono')->nullable();      // admite NULL
$table->boolean('activo')->default(true);    // valor por defecto
$table->string('codigo')->index();           // índice para búsquedas
$table->unique(['salida_id', 'numero_asiento']); // único compuesto
$table->string('obs')->comment('Observación');
```

### Claves foráneas (FK)

Forma corta (recomendada):

```php
$table->foreignId('salida_id')
      ->constrained('salidas')     // REFERENCES salidas(id)
      ->cascadeOnUpdate()
      ->cascadeOnDelete();         // al borrar la salida se borran sus asientos
```

Otras acciones al borrar: `->restrictOnDelete()` (impide borrar el padre si tiene hijos)
y `->nullOnDelete()` (pone NULL; la columna debe ser `->nullable()`).

Forma larga equivalente:

```php
$table->unsignedBigInteger('salida_id');
$table->foreign('salida_id')->references('id')->on('salidas')->onDelete('cascade');
```

> La tabla padre (`salidas`) debe migrarse **antes** que la hija (`asientos`):
> el orden lo da la fecha del nombre del archivo de migración.

### Tablas de este proyecto

**salidas**

| Columna | Definición |
|---|---|
| id | `$table->id()` |
| destino | `$table->string('destino', 100)` |
| fecha | `$table->date('fecha')` |
| hora | `$table->time('hora')` |
| bus | `$table->string('bus', 20)` |
| precio | `$table->decimal('precio', 8, 2)` |
| capacidad | `$table->unsignedInteger('capacidad')` |

**asientos**

| Columna | Definición |
|---|---|
| id | `$table->id()` |
| salida_id | `$table->foreignId('salida_id')->constrained('salidas')->cascadeOnDelete()` |
| numero_asiento | `$table->unsignedInteger('numero_asiento')` |
| ci_pasajero | `$table->string('ci_pasajero', 20)` |
| — | `$table->unique(['salida_id', 'numero_asiento'])` |

### Relación en los modelos

```php
// Salida.php
public function asientos(): HasMany
{
    return $this->hasMany(Asiento::class, 'salida_id');
}

// Asiento.php
public function salida(): BelongsTo
{
    return $this->belongsTo(Salida::class, 'salida_id');
}
```

En el modelo también se declaran los campos asignables y las conversiones:

```php
protected $fillable = ['destino', 'fecha', 'hora', 'bus', 'precio', 'capacidad'];

protected function casts(): array
{
    return ['fecha' => 'date:Y-m-d', 'precio' => 'decimal:2', 'capacidad' => 'integer'];
}
```

---

## 4. Factories (datos de prueba con Faker)

Un factory define cómo generar un registro falso. Se usa `fake()` (Faker).
Con `APP_FAKER_LOCALE=es_ES` en el `.env` los nombres y direcciones salen en español.

### Funciones de Faker más usadas

| Función | Ejemplo de resultado | Uso |
|---|---|---|
| `fake()->name()` | `María López` | Nombre completo |
| `fake()->firstName()` / `lastName()` | `Carlos` / `Pérez` | Nombre / apellido |
| `fake()->unique()->safeEmail()` | `juan@example.org` | Correo sin repetir |
| `fake()->phoneNumber()` | `+34 912 345 678` | Teléfono |
| `fake()->address()` / `city()` | `Calle Mayor 3` / `Sucre` | Dirección / ciudad |
| `fake()->numberBetween(1, 40)` | `27` | Entero en rango |
| `fake()->randomFloat(2, 10, 200)` | `87.45` | Decimal en rango |
| `fake()->randomElement(['A','B'])` | `B` | Uno de una lista |
| `fake()->boolean()` | `true` | Verdadero/falso |
| `fake()->date('Y-m-d')` | `2025-03-14` | Fecha |
| `fake()->time('H:i')` | `14:30` | Hora |
| `fake()->dateTimeBetween('now', '+30 days')` | DateTime | Fecha en un rango |
| `fake()->bothify('####-???')` | `2045-KXB` | `#` = dígito, `?` = letra (placas, códigos) |
| `fake()->numerify('########')` | `48213095` | Solo dígitos (CI) |
| `fake()->sentence()` / `paragraph()` | texto | Descripciones |
| `fake()->word()` | `lorem` | Una palabra |
| `fake()->uuid()` | `9b1d...` | Identificador único |

`unique()` evita repetir valores; `optional()` a veces devuelve `null`:
`fake()->optional()->phoneNumber()`.

### Factories de este proyecto

```php
// SalidaFactory
return [
    'destino'   => fake()->randomElement(['La Paz', 'Cochabamba', 'Santa Cruz', 'Potosí', 'Oruro', 'Tarija']),
    'fecha'     => fake()->dateTimeBetween('now', '+30 days')->format('Y-m-d'),
    'hora'      => fake()->randomElement(['07:00', '10:30', '14:00', '19:00', '21:30']),
    'bus'       => strtoupper(fake()->bothify('####-???')),
    'precio'    => fake()->randomElement([50, 70, 90, 120, 150]),
    'capacidad' => fake()->randomElement([40, 44, 48]),
];

// AsientoFactory
return [
    'salida_id'      => Salida::factory(),   // crea una salida si no se indica una
    'numero_asiento' => fake()->numberBetween(1, 40),
    'ci_pasajero'    => (string) fake()->numberBetween(1000000, 14999999),
];
```

### Cómo se usan (en seeders, tests o tinker)

```php
Salida::factory()->create();                  // 1 registro guardado
Salida::factory()->count(5)->create();        // 5 registros
Salida::factory()->make();                    // genera sin guardar
Salida::factory()->create(['destino' => 'Oruro']); // sobrescribe un campo

// Relaciones
Salida::factory()->has(Asiento::factory()->count(3))->create(); // salida con 3 asientos
Asiento::factory()->for($salida)->create();                     // asiento de una salida existente
```

### Seeders

```php
// DatabaseSeeder.php
$this->call([
    SalidaSeeder::class,   // primero el padre
    AsientoSeeder::class,  // luego los hijos
]);
```

```bash
php artisan db:seed                       # ejecuta DatabaseSeeder
php artisan db:seed --class=AsientoSeeder # solo uno
```
