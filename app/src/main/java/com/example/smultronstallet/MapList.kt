package com.example.smultronstallet

class MapList(var latitude : Double ,
              var longitude : Double,
              var image: Int,
              var review:String,
              businessMark:String) {

    var mapList = mutableListOf<MapList>(
        MapList(41.40338,2.17403,R.drawable.hokis1,"grymt bra restauran", "hökis grill"),
        MapList(59.322796,18.071644,R.drawable.chilenskmat,"pero super weno po", "chilensk Reastaurang"),
        MapList(41.40338,2.17403,R.drawable.indisk,"nam bröder var andra nivåer", "indisk restaurang"),
        MapList(41.40338,2.17403,R.drawable.thai,"maten var bra men stället var magisk", "thai"),
        MapList(41.40338,2.17403,R.drawable.hokis1,"grymt bra restauran", "hökis grill"),
        MapList(41.40338,2.17403,R.drawable.hokis1,"grymt bra restauran", "hökis grill"),
    )


}
