<?php

namespace Database\Seeders;

use App\Models\Asiento;
use App\Models\Salida;
use Illuminate\Database\Seeder;

class AsientoSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        
        Asiento::factory(20)->create();
    }
}
