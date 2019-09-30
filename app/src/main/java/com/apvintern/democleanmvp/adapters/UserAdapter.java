package com.apvintern.democleanmvp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.apvintern.democleanmvp.R;
import com.apvintern.democleanmvp.activities.MainContract;
import com.apvintern.democleanmvp.utils.UserDiffCallBack;
import com.apvintern.domain.entities.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> users;
    private MainContract.Presenter mainPresenter;

    public UserAdapter(List<User> users, MainContract.Presenter mainPresenter) {
        this.users = users;
        this.mainPresenter = mainPresenter;
    }

    public void updateUsers(List<User> newUsers) {
        UserDiffCallBack diffCallBack = new UserDiffCallBack(users, newUsers);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallBack);

        users.clear();
        users.addAll(newUsers);
        diffResult.dispatchUpdatesTo(this);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = users.get(position);
        holder.tvId.setText(String.valueOf(user.getId()));
        holder.tvName.setText(user.getName());
        holder.tvEmail.setText(user.getEmail());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        TextView tvId, tvName, tvEmail;
        CardView cvItemUser;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_item_id);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvEmail = itemView.findViewById(R.id.tv_item_email);
            cvItemUser = itemView.findViewById(R.id.cv_item_user);

            cvItemUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainPresenter.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}
