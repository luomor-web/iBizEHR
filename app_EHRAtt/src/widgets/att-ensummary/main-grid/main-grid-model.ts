/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof MainGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof MainGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'ygbh',
          prop: 'ygbh',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'ztc',
          prop: 'ztc',
          dataType: 'INT',
        },
        {
          name: 'bz',
          prop: 'bz',
          dataType: 'TEXT',
        },
        {
          name: 'sjcqts',
          prop: 'sjcqts',
          dataType: 'FLOAT',
        },
        {
          name: 'tq',
          prop: 'tq',
          dataType: 'FLOAT',
        },
        {
          name: 'ztf',
          prop: 'ztf',
          dataType: 'FLOAT',
        },
        {
          name: 'js',
          prop: 'js',
          dataType: 'FLOAT',
        },
        {
          name: 'remarkreason',
          prop: 'remarkreason',
          dataType: 'TEXT',
        },
        {
          name: 'wqdts',
          prop: 'wqdts',
          dataType: 'FLOAT',
        },
        {
          name: 'xxrjb',
          prop: 'xxrjb',
          dataType: 'FLOAT',
        },
        {
          name: 'br',
          prop: 'br',
          dataType: 'FLOAT',
        },
        {
          name: 'nx',
          prop: 'nx',
          dataType: 'FLOAT',
        },
        {
          name: 'srfmajortext',
          prop: 'attensummaryname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'attensummaryid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'attensummaryid',
          dataType: 'GUID',
        },
        {
          name: 'zw',
          prop: 'zw',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'kg',
          prop: 'kg',
          dataType: 'FLOAT',
        },
        {
          name: 'bj',
          prop: 'bj',
          dataType: 'FLOAT',
        },
        {
          name: 'description',
          prop: 'description',
          dataType: 'TEXT',
        },
        {
          name: 'zt',
          prop: 'zt',
          dataType: 'FLOAT',
        },
        {
          name: 'sz',
          prop: 'sz',
          dataType: 'FLOAT',
        },
        {
          name: 'qt',
          prop: 'qt',
          dataType: 'FLOAT',
        },
        {
          name: 'qq',
          prop: 'qq',
          dataType: 'FLOAT',
        },
        {
          name: 'tcxx',
          prop: 'tcxx',
          dataType: 'FLOAT',
        },
        {
          name: 'yf',
          prop: 'yf',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'sdt',
          prop: 'sdt',
          dataType: 'FLOAT',
        },
        {
          name: 'fdjrjb',
          prop: 'fdjrjb',
          dataType: 'FLOAT',
        },
        {
          name: 'qtdxj',
          prop: 'qtdxj',
          dataType: 'FLOAT',
        },
        {
          name: 'gzrjb',
          prop: 'gzrjb',
          dataType: 'FLOAT',
        },
        {
          name: 'sj',
          prop: 'sj',
          dataType: 'FLOAT',
        },
        {
          name: 'ormorgsectorname',
          prop: 'ormorgsectorname',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'ormorgname',
          prop: 'ormorgname',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'tx',
          prop: 'tx',
          dataType: 'FLOAT',
        },
        {
          name: 'zhts',
          prop: 'zhts',
          dataType: 'FLOAT',
        },
        {
          name: 'nd',
          prop: 'nd',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pc',
          prop: 'pc',
          dataType: 'FLOAT',
        },
        {
          name: 'yq',
          prop: 'yq',
          dataType: 'FLOAT',
        },
        {
          name: 'jh',
          prop: 'jh',
          dataType: 'FLOAT',
        },
        {
          name: 'cj',
          prop: 'cj',
          dataType: 'FLOAT',
        },
        {
          name: 'cdc',
          prop: 'cdc',
          dataType: 'INT',
        },
        {
          name: 'gs',
          prop: 'gs',
          dataType: 'FLOAT',
        },
        {
          name: 'cdf',
          prop: 'cdf',
          dataType: 'FLOAT',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'cc',
          prop: 'cc',
          dataType: 'FLOAT',
        },
        {
          name: 'cd',
          prop: 'cd',
          dataType: 'FLOAT',
        },
        {
          name: 'attensummary',
          prop: 'attensummaryid',
        },
      {
        name: 'n_nd_eq',
        prop: 'n_nd_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_yf_eq',
        prop: 'n_yf_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_pimpersonname_like',
        prop: 'n_pimpersonname_like',
        dataType: 'PICKUPTEXT',
      },

        {
          name:'size',
          prop:'size'
        },
        {
          name:'query',
          prop:'query'
        },
        {
          name:'page',
          prop:'page'
        },
        {
          name:'sort',
          prop:'sort'
        },
        {
          name:'srfparentdata',
          prop:'srfparentdata'
        },
        // 前端新增修改标识，新增为"0",修改为"1"或未设值
        {
          name: 'srffrontuf',
          prop: 'srffrontuf',
          dataType: 'TEXT',
        },
      ]
    }
  }

}