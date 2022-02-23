#!/bin/bash
#############################################################
## This script is used for bootstrapping servers for ansible
#############################################################

LOGFILE=/tmp/bootstrap.log
sudo -i <<EOF >> $LOGFILE 2>$LOGFILE
useradd ansadmin
cp /etc/sudoers /etc/sudoers-bkp-$date
echo "ansadmin ALL=(ALL)       NOPASSWD: ALL" >> /etc/sudoers
su - ansadmin <<EOF1 >> $LOGFILE 2>$LOGFILE
mkdir .ssh
chmod 700 .ssh
echo "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQCcSB+8KnuOZCcmil1t99xkWDTPrM0OyhcqfqO0ZykRrkOspmadIAf2/PJTGiyEBIplasvJrRzWLQrqhGZGXK8AF9fpPeQH7Mp2tMzFpnPv971/UNIYV9b88mK3ciuDa9hn4yX9x0iwz+q5AJOimFW1xtg5PUR09f3jwsk7leF5z3KNzFwtqzaF01mwpnP8hI7JwrT6OMZXuaIbhoGIhSQvA8Flhw4WGbLanqUYqJ6ZGlRum++FXKw11L8Cqq0t72i4ByajK/4ZZdLxcmt8kRePfJuLiixvAfRB4fh2J6e10P3tPHWj4EU/f6IV8KQN3o0J8z5Bbhb7GcQyvDDPznvBegWTX0vsV57OxC7WIVSl6P9GoTx3mlZw/qmrwaw9eyc/cvyt5tliMl6/IvMsUIEZKQB1+KUtLg7Y1POuhopZliBRBwP+f2d/pEJh3UWAtW/dlvP30tbZhDQUIN3jZI06I6vbgJFKiKOcqv/Go/zysQE2cXD6Ury+FnOqx2AzHxE= ansadmin@ip-172-31-91-71.ec2.internal" >> .ssh/authorized_keys
chmod 600 .ssh/authorized_keys
EOF1
EOF
