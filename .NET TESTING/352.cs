using System.Web.Mvc;

public class HomeController : Controller
{
    [HttpPost]
    [ValidateAntiForgeryToken]
    public ActionResult Login()
    {
        return View();
    }
}