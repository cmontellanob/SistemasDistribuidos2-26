<?php

namespace Database\Seeders;

use App\Models\Salida;
use Illuminate\Database\Seeder;

class SalidaSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        Salida::factory()->count(5)->create();
    }
}
