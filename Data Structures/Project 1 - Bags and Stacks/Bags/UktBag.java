public interface UktBag <T>
{
   public int getSize();
   public boolean isEmpty();
   public boolean add (T entry);
   public T remove();
   public boolean remove (T entry);
   public void clear();
   public int countObject(T Entry);
   public boolean containsObject(T entry);
   public T[] toArray();
}