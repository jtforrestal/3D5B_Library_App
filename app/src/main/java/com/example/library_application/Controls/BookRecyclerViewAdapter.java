package com.example.library_application.Controls;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.library_application.FullViewActivity;
import com.example.library_application.Model.Book;
import com.example.library_application.R;
import com.squareup.picasso.Picasso;


public class BookRecyclerViewAdapter extends RecyclerView.Adapter<BookRecyclerViewAdapter.ViewHolder>{

        public Context context;

        public Book[] bookList;
        private BookClickListener bookClickListener;

        public BookRecyclerViewAdapter(Context context, Book[] books) {
            this.context = context;
            this.bookList= books;

        }

        @Override
        public BookRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType )
        {
            View view= LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.book_row,parent,false);

            return new ViewHolder(view,context);
        }
        @Override
        public void onBindViewHolder(ViewHolder holder, int position)
        {

            Book book = bookList[position];
            holder.title.setText(book.getTitle());
            holder.author.setText(book.getAuthors());
            holder.description.setText(book.getDescription());

//            Picasso.get().setIndicatorsEnabled(true);
//            Picasso.get().setLoggingEnabled(true);

            if (book.getImages().length > 0) {
                Picasso.get()
                        .load(book.getImages()[0])
                        .resize(100,100).centerCrop()
                        .placeholder(android.R.drawable.ic_menu_slideshow)
                        .into(holder.cover);
            }
            else
            {
                Picasso.get().load(android.R.drawable.ic_menu_slideshow).into(holder.cover);
            }
        }

        @Override
        public int getItemCount(){
            return bookList.length;
        }

        public void setBookClickListener(BookClickListener listener){
            this.bookClickListener = listener;
        }

        public class ViewHolder extends RecyclerView.ViewHolder
                implements View.OnClickListener{
            TextView title;
            ImageView cover;
            TextView  description;
            TextView  author;



            public ViewHolder(View itemView,Context ctx){
                super(itemView);
                context=ctx;

                title = (TextView)itemView.findViewById(R.id.bookTitleID);
                cover = (ImageView)itemView.findViewById(R.id.bookImageID);
                author = (TextView)itemView.findViewById(R.id.bookAuthorID);
                description= (TextView)itemView.findViewById(R.id.bookDescriptionID);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                if(bookClickListener != null) bookClickListener.onClick(v, getAdapterPosition());

                //view.putExtra("TITLE", chosen_book.getTitle());
                //view.putExtra("AUTHOR", chosen_book.getAuthors());
                //view.putExtra("DESCRIPTION",chosen_book.getDescription());
                //view.putExtra("IMAGE", chosen_book.getImages());
                //kerntext.startActivity(full_view);
            }
        }
    }


