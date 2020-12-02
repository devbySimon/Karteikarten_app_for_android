package dev.by.simon.karteikarten.KarteiKarten;

public class KarteikartenManager
{
    private static KarteikartenManager karteikartenManager;
    
    private KarteikartenManager()
    {
    
    }
    
    public static KarteikartenManager getInstance()
    {
        if(KarteikartenManager.karteikartenManager == null)
        {
            KarteikartenManager.karteikartenManager = new KarteikartenManager();
        }
        
        return KarteikartenManager.karteikartenManager;
    }
}
