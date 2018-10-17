package codingwithmitch.com.databindinggettingstarted;
//https://www.youtube.com/watch?v=v4XO_y3RErI

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import codingwithmitch.com.databindinggettingstarted.databinding.ActivityMainBinding;
import codingwithmitch.com.databindinggettingstarted.models.Product;
import codingwithmitch.com.databindinggettingstarted.util.Products;

public class MainActivity extends AppCompatActivity implements IMainActivity {

    ActivityMainBinding mBinding;

    Product mProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding=DataBindingUtil.setContentView(this,R.layout.activity_main);

        Products products = new Products();

        mProduct= products.PRODUCTS[0];

        mBinding.setProduct(mProduct);
        mBinding.setQuantity(4);
        mBinding.setIMainActivity((IMainActivity)this);
       // mBinding.setTestUrl("https://i.redd.it/g5acbfi5hkm01.jpg");
    }

    @Override
    public void inflateQuantityDialog() {
        ChooseQuantityDialog dialog = new ChooseQuantityDialog();
        dialog.show(getSupportFragmentManager(),getString(R.string.dialog_choose_quantity));

    }

    @Override
    public void setQuatity(int quatity) {
        mBinding.setQuantity(quatity);
    }
}
