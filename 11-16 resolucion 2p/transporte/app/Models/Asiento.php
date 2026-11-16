<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;

class Asiento extends Model
{
    /** @use HasFactory<\Database\Factories\AsientoFactory> */
    use HasFactory;

    protected $table = 'asientos';

    protected $fillable = [
        'salida_id',
        'numero_asiento',
        'ci_pasajero',
    ];

    protected function casts(): array
    {
        return [
            'salida_id' => 'integer',
            'numero_asiento' => 'integer',
        ];
    }

    /** Cada asiento pertenece a una salida (FK salida_id) */
    public function salida(): BelongsTo
    {
        return $this->belongsTo(Salida::class, 'salida_id');
    }
}
