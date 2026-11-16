<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Supported\Facades\DB;


class ApiController extends Controller
{
    Private $Secreto ='clave_terminal_2026';
    private function base64url($texto)
    {
        return rtrim(strt(base64_encode($texto),'+','-','='));
    }
    private function creartoken
}
