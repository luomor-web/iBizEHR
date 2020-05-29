/**
 * BZCX 部件模型
 *
 * @export
 * @class BZCXModel
 */
export default class BZCXModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof BZCXGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof BZCXGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'orgsectorid',
          prop: 'orgsectorid',
          dataType: 'GUID',
        },
        {
          name: 'sjbzrs_color',
          prop: 'sjbzrs_color',
          dataType: 'TEXT',
        },
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
          name: 'bmbzrs',
          prop: 'bmbzrs',
          dataType: 'INT',
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
          name: 'ormxmglid',
          prop: 'ormxmglid',
          dataType: 'PICKUP',
        },
        {
          name: 'orgsectorname',
          prop: 'orgsectorname',
          dataType: 'TEXT',
        },
        {
          name: 'sjrs',
          prop: 'sjrs',
          dataType: 'INT',
        },
        {
          name: 'ormorgsector',
          prop: 'orgsectorid',
        },
      {
        name: 'n_orgname_like',
        prop: 'n_orgname_like',
        dataType: 'PICKUPTEXT',
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