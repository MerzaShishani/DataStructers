public class Array {
    private int[] items;
    private int count;

    public Array(int length){
        items = new int[length];
    }

    public void print(){
        for (int i=0; i<count; i++)
            System.out.println(items[i]);
    }

    private void resizeIfRequired(){
        if(items.length == count){
            int[] newItems = new int[count * 2];

            for (int i=0; i<count; i++)
                newItems[i] = items[i];
            items = newItems;
        }
    }

    public void insert(int item){
        resizeIfRequired();
        items[count++]=item;
    }

    public void insertAt(int item, int index){
        resizeIfRequired();

        for (int i= count-1; i<=index; i--)
            items[i+1] = items[i];

        items[index]=item;
        count++;
    }

    public void removeAt(int index) {
        if (index<1 || index>=count)
            throw new IllegalArgumentException();

        for (int i=index; i<count; i++)
            items[i] = items[i+1];
        count--;
    }

    public int indexOf(int item){
        for (int i=0; i<count; i++)
            if(items[i] == item)
                return i;

        return -1;
    }

    public int max(){
        int max= items[0];
        for (int i=0; i<count; i++)
            if(items[i]> max)
                max=items[i];
        return max;
    }

    public Array intersect(Array other){
        Array intersection = new Array(count);
        for (int i=0; i<count; i++)
            for (int j=0; j<other.count; j++)
                if(items[i] == items[j])
                    intersection.insert(items[i]);

                return intersection;
    }

    public void reverse(){
        int[] newItems = new int[count];
        for (int i = 0; i<count; i++)
            items[i] = items[count - i - 1];
        items = newItems;
    }
}
