/**
 * GWChoice 部件模型
 *
 * @export
 * @class GWChoiceModel
 */
export default class GWChoiceModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof GWChoiceGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof GWChoiceGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'xh',
          prop: 'xh',
          dataType: 'INT',
        },
        {
          name: 'ormpostname',
          prop: 'ormpostname',
          dataType: 'TEXT',
        },
        {
          name: 'iskeypostion',
          prop: 'iskeypostion',
          dataType: 'SSCODELIST',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'createdate',
          prop: 'createdate',
          dataType: 'DATETIME',
        },
        {
          name: 'srfmajortext',
          prop: 'ormpostname',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'ormpostid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'ormpostid',
          dataType: 'GUID',
        },
        {
          name: 'ormorgname',
          prop: 'ormorgname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'gwtype',
          prop: 'gwtype',
          dataType: 'SMCODELIST',
        },
        {
          name: 'postnature',
          prop: 'postnature',
          dataType: 'SSCODELIST',
        },
        {
          name: 'istemp',
          prop: 'istemp',
          dataType: 'SSCODELIST',
        },
        {
          name: 'createman',
          prop: 'createman',
          dataType: 'TEXT',
        },
        {
          name: 'ormpost',
          prop: 'ormpostid',
        },
      {
        name: 'n_ormpostname_like',
        prop: 'n_ormpostname_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_ormorgname_like',
        prop: 'n_ormorgname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_startstopsign_eq',
        prop: 'n_startstopsign_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_gwtype_eq',
        prop: 'n_gwtype_eq',
        dataType: 'SMCODELIST',
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