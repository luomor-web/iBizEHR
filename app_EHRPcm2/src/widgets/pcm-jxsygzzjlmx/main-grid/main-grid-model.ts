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
          name: 'rzqd',
          prop: 'rzqd',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'ygbh',
          prop: 'ygbh',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'zzgw',
          prop: 'zzgw',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'jssj',
          prop: 'jssj',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'zz',
          prop: 'zz',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'srfmajortext',
          prop: 'pcmjxsygzzjlmxname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pcmjxsygzzjlmxid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pcmjxsygzzjlmxid',
          dataType: 'GUID',
        },
        {
          name: 'duration',
          prop: 'duration',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'pcmjxszzkhjgjlid',
          prop: 'pcmjxszzkhjgjlid',
          dataType: 'PICKUP',
        },
        {
          name: 'checkstatus',
          prop: 'checkstatus',
          dataType: 'SSCODELIST',
        },
        {
          name: 'bm',
          prop: 'bm',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'pcmjxsygzzsqid',
          prop: 'pcmjxsygzzsqid',
          dataType: 'PICKUP',
        },
        {
          name: 'fs',
          prop: 'fs',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'pcmjxsygzzsqname',
          prop: 'pcmjxsygzzsqname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'pj',
          prop: 'pj',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'pcmjxsygzzjlmx',
          prop: 'pcmjxsygzzjlmxid',
        },
      {
        name: 'n_pimpersonname_like',
        prop: 'n_pimpersonname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_ygbh_like',
        prop: 'n_ygbh_like',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'n_duration_eq',
        prop: 'n_duration_eq',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'n_checkstatus_eq',
        prop: 'n_checkstatus_eq',
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