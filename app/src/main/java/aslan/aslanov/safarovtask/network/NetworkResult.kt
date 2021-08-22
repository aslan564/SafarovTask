package aslan.aslanov.safarovtask.network

data class NetworkResult<T>(val status:Status,val msg:String?,val data:T?){
    companion object {
        fun <T>success(data:T?):NetworkResult<T>{
            return NetworkResult(Status.SUCCESS,null,data)
        }

        fun <T> loading(): NetworkResult<T> {
            return NetworkResult(Status.LOADING,null,null)
        }

        fun <T>error(msg: String?):NetworkResult<T>{
            return NetworkResult(Status.ERROR,msg,null)
        }
    }
}

enum class Status{
    SUCCESS,LOADING,ERROR
}