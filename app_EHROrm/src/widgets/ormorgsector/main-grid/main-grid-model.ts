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
          name: 'proleaderid',
          prop: 'proleaderid',
          dataType: 'PICKUP',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'porgsectorid',
          prop: 'porgsectorid',
          dataType: 'PICKUP',
        },
        {
          name: 'bmlx',
          prop: 'bmlx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'srfmajortext',
          prop: 'orgsectorname',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'orgsectorid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'orgsectorid',
          dataType: 'GUID',
        },
        {
          name: 'validflag',
          prop: 'validflag',
          dataType: 'YESNO',
        },
        {
          name: 'prodepid',
          prop: 'prodepid',
          dataType: 'PICKUP',
        },
        {
          name: 'orgcode',
          prop: 'orgcode',
          dataType: 'TEXT',
        },
        {
          name: 'orgid',
          prop: 'orgid',
          dataType: 'PICKUP',
        },
        {
          name: 'orgname',
          prop: 'orgname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'qy',
          prop: 'qy',
          dataType: 'SSCODELIST',
        },
        {
          name: 'ormxmglid',
          prop: 'ormxmglid',
          dataType: 'PICKUP',
        },
        {
          name: 'shortname',
          prop: 'shortname',
          dataType: 'TEXT',
        },
        {
          name: 'ordervalue',
          prop: 'ordervalue',
          dataType: 'INT',
        },
        {
          name: 'orgsectorname',
          prop: 'orgsectorname',
          dataType: 'TEXT',
        },
        {
          name: 'ormorgsector',
          prop: 'orgsectorid',
        },
      {
        name: 'n_zzdzs_like',
        prop: 'n_zzdzs_like',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'n_orgsectorname_like',
        prop: 'n_orgsectorname_like',
        dataType: 'TEXT',
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