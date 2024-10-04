package Pages;
import Data.ConstantsData;
import Maps.CheckOutPageMap;
import Maps.MainPageMap;
import Utils.CommonCommands;

public class CheckOutPage {
    CommonCommands commands;

    public CheckOutPageMap checkOutPageMap = new CheckOutPageMap();
    public MainPageMap mainPageMap = new MainPageMap();
    public CheckOutPage(CommonCommands commands) {
        this.commands = commands;
    }
    public void buyZaraCoat3(){
        commands.isElementVisible(mainPageMap.waitArticlesToAppear);
        commands.isElementVisible(mainPageMap.alertMessage);
        commands.waitForElementToDisappear(mainPageMap.spinner);
        commands.clickElement(mainPageMap.shoppingCart);
        commands.scrollToElementAndClick(checkOutPageMap.CheckoutBtn);
        commands.sendKeysToElement(checkOutPageMap.CvvBox, ConstantsData.CVV_BOX);
        commands.sendKeysToElement(checkOutPageMap.NameOnCard, ConstantsData.NAMECARD);
        commands.sendKeysToElement(checkOutPageMap.Country, ConstantsData.COUNTRY);
        commands.clickElement(checkOutPageMap.CountryBtn);
        commands.scrollToElementAndClick(checkOutPageMap.PlaceOrder);

    }
        public void buyMoreProducts() {
            // Asegurarse de que los productos estén visibles
            commands.isElementVisible(mainPageMap.waitArticlesToAppear);

            // Verificar que aparezca un mensaje de alerta (si es aplicable)
            commands.isElementVisible(mainPageMap.alertMessage);

            // Esperar a que desaparezca cualquier spinner de carga
            commands.waitForElementToDisappear(mainPageMap.spinner);

            // Navegar al carrito y proceder con el pago
            commands.clickElement(mainPageMap.shoppingCart);

            // Desplazarse y hacer clic en el botón de checkout
            commands.scrollToElementAndClick(checkOutPageMap.CheckoutBtn);

            // Llenar la información de pago
            commands.sendKeysToElement(checkOutPageMap.CvvBox, ConstantsData.CVV_BOX);
            commands.sendKeysToElement(checkOutPageMap.NameOnCard, ConstantsData.NAMECARD);
            commands.sendKeysToElement(checkOutPageMap.Country, ConstantsData.COUNTRY);

            // Confirmar el país y realizar la compra
            commands.clickElement(checkOutPageMap.CountryBtn);
            commands.scrollToElementAndClick(checkOutPageMap.PlaceOrder);
        }

    }

