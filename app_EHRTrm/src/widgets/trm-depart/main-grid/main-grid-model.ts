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
          name: 'trmdepartname',
          prop: 'trmdepartname',
          dataType: 'TEXT',
        },
        {
          name: 'ormorgsectorid',
          prop: 'ormorgsectorid',
          dataType: 'PICKUP',
        },
        {
          name: 'tzlx',
          prop: 'tzlx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'srfmajortext',
          prop: 'trmdepartname',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'trmdepartid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'trmdepartid',
          dataType: 'GUID',
        },
        {
          name: 'ormorgname',
          prop: 'ormorgname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'jzrq',
          prop: 'jzrq',
          dataType: 'DATE',
        },
        {
          name: 'jd',
          prop: 'jd',
          dataType: 'SSCODELIST',
        },
        {
          name: 'tdrq',
          prop: 'tdrq',
          dataType: 'DATE',
        },
        {
          name: 'zzdzs',
          prop: 'zzdzs',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'nd',
          prop: 'nd',
          dataType: 'SSCODELIST',
        },
        {
          name: 'shortname',
          prop: 'shortname',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'lclx',
          prop: 'lclx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'trmdepart',
          prop: 'trmdepartid',
        },
      {
        name: 'n_trmdepartname_like',
        prop: 'n_trmdepartname_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_ormorgname_eq',
        prop: 'n_ormorgname_eq',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_ormorgsectorname_like',
        prop: 'n_ormorgsectorname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_nd_eq',
        prop: 'n_nd_eq',
        dataType: 'SSCODELIST',
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