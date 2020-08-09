<?php

use Illuminate\Support\Facades\Route;


/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () { //funckja generujaca tylko napis
    return view('welcome');
});

Route::get('doctors/', 'DoctorController@index');


/*
Route::get('/test/{name}/{number?}', function ($name, $number = 100) {
        return $name . "-" . $number;
});
 */

/*
 * Łączenie tych funkcji, też można takie coś zrobić 
Route::match(['get', 'post'], '/', function (){
    return ;
});
 */

/*
Route::prefix('admin')->group(function(){
    Route::get('/test/{name}/{number?}', function ($name, $number = 100) {
        return $name . "-" . $number;
    })->name('testowaTrasa');
});
 */