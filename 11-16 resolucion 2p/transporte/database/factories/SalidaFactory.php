<?php

namespace Database\Factories;

use App\Models\Salida;
use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends Factory<Salida>
 */
class SalidaFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'destino' => fake()->randomElement(['La Paz', 'Cochabamba', 'Santa Cruz', 'Potosí', 'Oruro', 'Tarija']),
            'fecha' => fake()->dateTimeBetween('now', '+30 days')->format('Y-m-d'),
            'bus' => strtoupper(fake()->bothify('####-???')),
            'precio' => fake()->randomElement([50, 70, 90, 120, 150]),
            'capacidad' => fake()->randomElement([40, 44, 48]),
        ];
    }
}
