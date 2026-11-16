<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class ApiController extends Controller
{
    private $Secreto = 'clave_terminal_2026';

    private function base64url($texto)
    {
        return rtrim(strtr(base64_encode($texto), '+/', '-_'), '=');
    }

    private function creartoken($email)
    {
        $h = $this->base64url(json_encode(['alg' => 'HS256', 'typ' => 'JWT']));
        $p = $this->base64url(json_encode(['email' => $email, 'iat' => time(), 'exp' => time() + 3600]));
        $f = $this->base64url(hash_hmac('sha256', "$h.$p", $this->Secreto, true));

        return "$h.$p.$f";
    }
}
