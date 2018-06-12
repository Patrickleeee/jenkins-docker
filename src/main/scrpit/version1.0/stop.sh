echo "==========Stopping jenkins-docker Start=========="
pid=`ps -ef | grep jenkins-docker-1.0.jar | grep -v grep | awk '{print $2}'`
if [ -n "$pid" ]
then
   echo "kill -9 的pid:" $pid
   kill -9 $pid
fi
echo "==========Stopping jenkins-docker Finish=========="
