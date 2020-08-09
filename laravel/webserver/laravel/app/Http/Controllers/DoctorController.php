<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class DoctorController extends Controller
{
   public function index(){
       $doctorsList = array(
           array("id"=>1, "lastname"=>"Newman", "firstname"=>"John", "email"=>"john@newman.com", "phone"=>"123123123", "adress"=>"Adress1", "status"=>"Dostępny"),
           array("id"=>2, "lastname"=>"Nowak", "firstname"=>"Adam", "email"=>"adam@nowak.com", "phone"=>"123123123", "adress"=>"Adress2", "status"=>"Niedostępny"),
           array("id"=>3, "lastname"=>"Polak", "firstname"=>"Bob", "email"=>"bob@polak.com", "phone"=>"123123123", "adress"=>"Adress3", "status"=>"Dostępny")
       );
       return view('doctors.list', ["doctorsList"=>$doctorsList,
                                    "footerYear"=>date("Y"),
                                    "title"=>"Moduł lekarzy"]);
   }
}
