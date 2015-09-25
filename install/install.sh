# cat install.sh 
#!/bin/bash
install_dir=/usr/local/lib/gim
if [[ -e $install_dir ]];then
    rm -rf $install_dir/site
else
    mkdir -p $install_dir
fi
sed -n '1,/^exit 0$/!p' $0 >$install_dir/site.tar.gz

cd $install_dir
tar -xzvf site.tar.gz

if [[ -e /etc/gim ]];then
    rm -rf /etc/gim/db.conf
    rm -rf /etc/gim/site.conf
else
    mkdir /etc/gim
fi

cd $install_dir/site
cp conf/* /etc/gim
cp init.d/gim-site /etc/rc.d/init.d

chmod 755 bin/*
chmod 755 /etc/rc.d/init.d/gim-site
chkconfig gim-site on

path=$(pwd)
mysql -uroot << EOF
use gim
source $path/sql/create_objects.sql;
EOF

rm -rf $install_dir/site.tar.gz

exit 0
