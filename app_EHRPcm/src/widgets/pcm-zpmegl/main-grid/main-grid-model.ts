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
          name: 'fpme_sza',
          prop: 'fpme_sza',
          dataType: 'TEXT',
        },
        {
          name: 'fpme_szb',
          prop: 'fpme_szb',
          dataType: 'TEXT',
        },
        {
          name: 'fpme_xzxzy',
          prop: 'fpme_xzxzy',
          dataType: 'TEXT',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'fpme_xzb',
          prop: 'fpme_xzb',
          dataType: 'TEXT',
        },
        {
          name: 'fpme_xza',
          prop: 'fpme_xza',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'pcmzpmeglname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pcmzpmeglid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pcmzpmeglid',
          dataType: 'GUID',
        },
        {
          name: 'zzdzs',
          prop: 'zzdzs',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'fpme_szy',
          prop: 'fpme_szy',
          dataType: 'TEXT',
        },
        {
          name: 'nd',
          prop: 'nd',
          dataType: 'TEXT',
        },
        {
          name: 'pfcs',
          prop: 'pfcs',
          dataType: 'INT',
        },
        {
          name: 'fpme_szjhw',
          prop: 'fpme_szjhw',
          dataType: 'TEXT',
        },
        {
          name: 'pcmzpmegl',
          prop: 'pcmzpmeglid',
        },
      {
        name: 'n_nd_eq',
        prop: 'n_nd_eq',
        dataType: 'TEXT',
      },
      {
        name: 'n_ormorgname_eq',
        prop: 'n_ormorgname_eq',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_ormorgid_eq',
        prop: 'n_ormorgid_eq',
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