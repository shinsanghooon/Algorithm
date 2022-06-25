package basic.generics;

//public class Box {
//    Object item;
//
//    void setItem(Object item) {
//        this.item = item;
//    }
//
//    Object getItem() {
//        return item;
//    }
//}


public class Box<T> {
    T item;

    void setItem(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }
}
