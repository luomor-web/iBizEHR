/**
 * HisRec 部件模型
 *
 * @export
 * @class HisRecModel
 */
export default class HisRecModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof HisRecGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof HisRecGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'fj',
          prop: 'fj',
          dataType: 'TEXT',
        },
        {
          name: 'ygbh',
          prop: 'ygbh',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'sqsj',
          prop: 'sqsj',
          dataType: 'DATE',
        },
        {
          name: 'bgnr',
          prop: 'bgnr',
          dataType: 'TEXT',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'reason',
          prop: 'reason',
          dataType: 'LONGTEXT_1000',
        },
        {
          name: 'zt',
          prop: 'zt',
          dataType: 'SSCODELIST',
        },
        {
          name: 'bglx',
          prop: 'bglx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'srfmajortext',
          prop: 'pimpersonchangename',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimpersonchangeid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pimpersonchangeid',
          dataType: 'GUID',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'pimpersonchange',
          prop: 'pimpersonchangeid',
        },
      {
        name: 'n_pimpersonname_like',
        prop: 'n_pimpersonname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_bglx_eq',
        prop: 'n_bglx_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_zt_eq',
        prop: 'n_zt_eq',
        dataType: 'SSCODELIST',
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