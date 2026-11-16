<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Route;

// Genera un JWT HS256: header.payload.firma (base64url)
$creartoken = function (string $email): string {
    $secreto = 'clave_terminal_2026';
    $b64 = fn (string $t) => rtrim(strtr(base64_encode($t), '+/', '-_'), '=');

    $h = $b64(json_encode(['alg' => 'HS256', 'typ' => 'JWT']));
    $p = $b64(json_encode(['email' => $email, 'iat' => time(), 'exp' => time() + 3600]));
    $f = $b64(hash_hmac('sha256', "$h.$p", $secreto, true));

    return "$h.$p.$f";
};
