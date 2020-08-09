@extends('template')

@section('title') 
    @if(isset($title))
        - {{ $title }}
    @endif
@endsection

@section('content')
<table class="table">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Email</th>
            <th scope="col">Phone</th>
            <th scope="col">Adress</th>
            <th scope="col">Status</th>
          </tr>
        </thead>
        <tbody>
        @foreach ($doctorsList as $doctor)
            <tr>
              <th scope="row">{{$doctor['id']}}</th>
              <td>{{$doctor['firstname']}}</td>
              <td>{{$doctor['lastname']}}</td>
              <td>{{$doctor['email']}}</td>
              <td>{{$doctor['phone']}}</td>
              <td>{{$doctor['adress']}}</td>
              <td>{{$doctor['status']}}</td>
            </tr>
        @endforeach
        </tbody>
</table>
@endsection('content')