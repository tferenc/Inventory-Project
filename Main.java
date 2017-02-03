public class Main
{
    public static void main(String[] args) throws Exception
    {
        StorageManager store = new StorageManager();
        StoreCapable sc = new PersistentStore();

        store.addStorage(sc);
        store.addCdProduct("kovbojok", 2000, 20);

        StorageManager valami = new StorageManager();
        StoreCapable nemtommi = new PersistentStore();

        valami.addStorage(nemtommi);
        valami.addBookProduct("randomkönyv", 3000, 400);
    }

}
