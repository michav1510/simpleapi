# simpleapi

This is a simple rest API written in clojure, with three endpoints.
1)add : With this endpoint you can write to the database your location in form of latitude and longitude
and send your username also.
The usage for example is: /add?lat=36&long=36&user=michav 
If the data were written succesfully then you take as reply a json :
{
    "get": {
        "status": 200,
        "body": "Ok"
    }
}
2)request : With this endpoint you can request the data written in the database.
The usage is simple : /request 
You will take as reply a json with all the requested data, for example : 
{
    "get": {
        "status": 200,
        "traces": [
            {
                "timestamp": "2020-09-11 14:29:30",
                "lat": 36.0,
                "long": 36.0,
                "user": "michav"
            },
            {
                "timestamp": "2020-10-17 08:49:57",
                "lat": 36.0,
                "long": 36.0,
                "user": "michav"
            }
        ]
    }
}
3)ping : This is a check to see if there is a reply, typically the reply is :
{
    "get": {
        "status": 200,
        "body": "Ok"
    }
}

## Usage

Run "lein deps" in order to see if all the dependencies are installed.
Then run "lein ring server <number_of_port>" for example "lein ring server 3000".

## License

Copyright © 2020 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
