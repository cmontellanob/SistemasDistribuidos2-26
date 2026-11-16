<?php

namespace Database\Factories;

use App\Models\Asiento;
use App\Models\Salida;
use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends Factory<Asiento>
 */
class AsientoFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'salida_id' => Salida::factory(),
            'numero_asiento' => fake()->numberBetween(1, 40),
            'ci_pasajero' => (string) fake()->numberBetween(1000000, 14999999),
        ];
    }
}
