package Maps


import com.google.firebase.firestore.DocumentId

class Place(@DocumentId var docId : String? = null, var name : String ="",var latitude: Double?=0.0,var longitude :Double?=0.0,var review : String? =null, var imageURL:String? =null ){

}