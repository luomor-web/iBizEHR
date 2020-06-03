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
          name: 'synjts',
          prop: 'synjts',
          dataType: 'FLOAT',
        },
        {
          name: 'ygbh',
          prop: 'ygbh',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'sjbnts',
          prop: 'sjbnts',
          dataType: 'FLOAT',
        },
        {
          name: 'yynj',
          prop: 'yynj',
          dataType: 'FLOAT',
        },
        {
          name: 'zz',
          prop: 'zz',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'srfmajortext',
          prop: 'vacsynjcxname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'vacsynjcxid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'vacsynjcxid',
          dataType: 'GUID',
        },
        {
          name: 'gly',
          prop: 'gly',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'vacsynjcxid',
          prop: 'vacsynjcxid',
          dataType: 'GUID',
        },
        {
          name: 'bnts',
          prop: 'bnts',
          dataType: 'FLOAT',
        },
        {
          name: 'jsyxsj',
          prop: 'jsyxsj',
          dataType: 'DATE',
        },
        {
          name: 'nd',
          prop: 'nd',
          dataType: 'SSCODELIST',
        },
        {
          name: 'bm',
          prop: 'bm',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'ksyxsj',
          prop: 'ksyxsj',
          dataType: 'DATE',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'vacsynjcx',
          prop: 'vacsynjcxid',
        },
      {
        name: 'n_pimpersonname_like',
        prop: 'n_pimpersonname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_nd_eq',
        prop: 'n_nd_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_zz_like',
        prop: 'n_zz_like',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'n_bm_like',
        prop: 'n_bm_like',
        dataType: 'PICKUPDATA',
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