public class Stack {

    //following the logic LIFO

    public Object [] array;

    public Stack(int maxQuantity){
        array = new Object[maxQuantity];
    }

    public Object pop(){
        Object element = null;
        for (int i = array.length -1; i >= 0; i--) {
            if(array[i] != null){
                element = array[i];
                array[i] = null;
                break;
            }
        }
        if(element==null){
            System.out.println("element is null");
        }
        return element;
    }

    public Object peek(){
        Object element = null;
        for (int i = array.length -1; i >= 0; i--) {
            if(array[i] != null){
                element = array[i];
                break;
            }
        }
        return element;
    }

    public void push(Object element){
        for (int i = 0; i < array.length; i++) {
            if(array[i] == null){
                array[i] = element;
                break;
            }
        }
    }

    public boolean empty(){
        boolean isEmpty = true;
        for (int i = 0; i < array.length; i++) {
            if(array[i] != null){
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }

    public boolean full(){
        boolean isFull = true;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == null){
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void showElements(){
        for (int i = 0; i < array.length; i++) {
            if(array[i] != null){
                System.out.println(array[i]);
            }
        }
        System.out.println("--------------");
    }

}
