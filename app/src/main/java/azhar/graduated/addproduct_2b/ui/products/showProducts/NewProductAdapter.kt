package azhar.graduated.addproduct_2b.ui.products.showProducts

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import azhar.graduated.addproduct_2b.ProductRepoInterface
import azhar.graduated.addproduct_2b.R
import azhar.graduated.addproduct_2b.data.DB.ProductEntity
import azhar.graduated.addproduct_2b.databinding.ListItemBinding
import azhar.graduated.addproduct_2b.ui.products.editProducts.EditProductsViewModel

class NewProductAdapter (private var list :List<ProductEntity>,
    val onDeleteProduct : ( id :Long) -> Unit
            , val onEditButtonClicked: (product: ProductEntity) -> Unit):
    RecyclerView.Adapter<NewProductAdapter.ProductViewHolder>(){

    lateinit var binding: ListItemBinding

    //viewHolder
  inner  class ProductViewHolder( val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: ProductEntity) {
            binding.listItemName.text=item.name
            binding.listItemQuentity.text=item.quantity.toString()
            binding.listItemPrice.text=item.price
            binding.listItemTotalPrice.text=item.totalPrice

            binding.listItemButtonDelet.setOnClickListener {
                    onDeleteProduct(item.id)
            }

            binding.listItemButtonEdit.setOnClickListener{
                onEditButtonClicked(item)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        //inflate
        binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = list?.get(position)
        if (product != null) {
            holder.bind(product)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    // Add a method to update the list
    fun updateList(newList: List<ProductEntity>) {
        list = newList
        notifyDataSetChanged()
    }
}