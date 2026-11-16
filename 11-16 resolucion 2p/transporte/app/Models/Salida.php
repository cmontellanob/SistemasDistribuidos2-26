<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\HasMany;

class Salida extends Model
{
    /** @use HasFactory<\Database\Factories\SalidaFactory> */
    use HasFactory;

    protected $table = 'salidas';

    protected $fillable = [
        'destino',
        'fecha',
        'hora',
        'bus',
        'precio',
        'capacidad',
    ];

    protected function casts(): array
    {
        return [
            'fecha' => 'date:Y-m-d',
            'precio' => 'decimal:2',
            'capacidad' => 'integer',
        ];
    }

    /** Una salida tiene muchos asientos vendidos */
    public function asientos(): HasMany
    {
        return $this->hasMany(Asiento::class, 'salida_id');
    }
}
