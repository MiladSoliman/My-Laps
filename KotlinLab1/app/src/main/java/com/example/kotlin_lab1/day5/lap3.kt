package com.example.kotlin_lab1.day5

abstract open class LibraryItem (var title:String , var isbn:Int, var publication :String , var noOfPages :Int){
    abstract fun isAvaliable(item: LibraryItem):Boolean
}

class Book(title: String, isbn: Int, publication: String, noOfPages: Int) :
    LibraryItem(title, isbn, publication, noOfPages) {
    override fun isAvaliable(item: LibraryItem): Boolean {
        var avaliable = false
        if (LibrarayDatabase.avalibleBooks.contains(item)){
            avaliable= true
        }
        return avaliable
    }

    override fun toString(): String {
        return ("the title is ${this.title} , the ISBN is ${this.isbn} , the is publication is ${this.publication} and the noumber of pages ${this.noOfPages}")
    }

}

open class person (var name:String, var id:Int){

}

class Librarian(name: String , id: Int ): person(name , id){
    constructor(name: String , id: Int , password :String):this(name , id)
    constructor():this("",0," ")
}

class User(name: String, id: Int) : person(name, id){
    constructor(name: String , id: Int , jop :String):this(name , id)
}



class LibrarayDatabase {
    var currentLibrary :Librarian = Librarian ()
    companion object {
        var avalibleBooks: MutableList<Book> = mutableListOf()
    }
    var borrwoedBooks : MutableMap <Book , User> = mutableMapOf()

   fun addBook (book: Book){
       avalibleBooks.add(book)
   }

   fun lentBook(book: Book , user: User):Int{
       var finded:Int = 0
           if (book.isAvaliable(book)) {
               avalibleBooks.remove(book)
               borrwoedBooks.put(book, user)
               finded = 1
           }else{
               println("Book not found")
           }
       return finded
       }

   fun viewAvaliableBooks(){
       for (i in 0 until  avalibleBooks.size){
           println(avalibleBooks.get(i).toString() )
       }
   }

   fun searchforABook(book: Book) : Boolean{
       var finded :Boolean = false
       for (i in 0..avalibleBooks.size-1){
           if (avalibleBooks.contains(book)){
               finded = true
           }

       }
       return finded
   }

   fun recieveBookFromBorrower(book: Book){
       borrwoedBooks.remove(book)
       addBook(book)
   }

}



fun main(){
    var item :Book = Book("math",1,"Milad",440)
    var book1 :Book = Book("scince",2,"Mina",448)
    var book2:Book = Book("calc",3,"Gedo",500)
    var book3:Book =Book("Drasat",4,"Eslam",555)
    var book4:Book = Book("rasm",5,"Essam",778)

    var book5:Book = Book("ay 7aga",8,"hhhhh",800)


    var librarayDatabase:LibrarayDatabase = LibrarayDatabase()
   librarayDatabase.currentLibrary = Librarian("Ahmed",45,"45454554")

    librarayDatabase.addBook(item)
    librarayDatabase.addBook(book1)
    librarayDatabase.addBook(book2)
    librarayDatabase.addBook(book3)
    librarayDatabase.addBook(book4)

   librarayDatabase.viewAvaliableBooks()

    var result:Boolean = librarayDatabase.searchforABook(book1)
     println("is book founded : $result" )
    var result2 :Boolean = librarayDatabase.searchforABook(book5)

    println("is book founded : $result2"  )


   var sara :User = User("Sara" , 10 , "Student")
    var nada :User = User("Nada" , 11 , "Student")
    var hadia :User = User("Hadya" , 12 , "Student")
    var mayada :User = User("Mayada" , 13 , "Student")

    librarayDatabase.lentBook(item,sara)
    librarayDatabase.lentBook(book1,nada)
    librarayDatabase.lentBook(book2,hadia)
    librarayDatabase.lentBook(book3,mayada)

    println("after browing")
    librarayDatabase.viewAvaliableBooks()

   librarayDatabase.recieveBookFromBorrower(item)


    println("after reciving")
    librarayDatabase.viewAvaliableBooks()


}
