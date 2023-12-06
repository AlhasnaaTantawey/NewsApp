package azhar.graduated.addproduct_2b.ui.products.showProducts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import azhar.graduated.addproduct_2b.data.DB.ProductEntity
import azhar.graduated.addproduct_2b.databinding.ListItemBinding

class ProductsAdapter(private val viewModel: showProductsViewModel) :ListAdapter<ProductEntity,ProductsAdapter.ProductViewHolder>(ProductDiffCallback) {
    lateinit var binding: ListItemBinding


    //viewHolder
    class ProductViewHolder( var binding: ListItemBinding,private val viewModel: showProductsViewModel) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: ProductEntity) {
            binding.listItemName.text=item.name
            binding.listItemQuentity.text=item.quantity.toString()
            binding.listItemPrice.text=item.price
            binding.listItemTotalPrice.text=item.totalPrice

            binding.listItemButtonDelet.setOnClickListener {
                val position =adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    viewModel.deleteProduct(position.toLong())

                }
            }
        }
    }
    //diffutil
    object ProductDiffCallback : DiffUtil.ItemCallback<ProductEntity>() {
        override fun areItemsTheSame(oldItem: ProductEntity, newItem: ProductEntity): Boolean {
            return oldItem.id==newItem.id
        }
        override fun areContentsTheSame(oldItem: ProductEntity, newItem: ProductEntity): Boolean {
            return oldItem == newItem
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        //inflate
        binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding,viewModel)

    }
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
       var product= getItem(position)
        holder.bind(product)
    }


}