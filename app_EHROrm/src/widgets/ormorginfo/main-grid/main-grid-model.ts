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
          name: 'belongregion',
          prop: 'belongregion',
          dataType: 'SSCODELIST',
        },
        {
          name: 'ordernum',
          prop: 'ordernum',
          dataType: 'TEXT',
        },
        {
          name: 'porgid',
          prop: 'porgid',
          dataType: 'TEXT',
        },
        {
          name: 'substandard',
          prop: 'substandard',
          dataType: 'SSCODELIST',
        },
        {
          name: 'srfmajortext',
          prop: 'ormorginfoname',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'ormorginfoid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'ormorginfoid',
          dataType: 'GUID',
        },
        {
          name: 'orgtype',
          prop: 'orgtype',
          dataType: 'TEXT',
        },
        {
          name: 'orgcode',
          prop: 'orgcode',
          dataType: 'TEXT',
        },
        {
          name: 'startstopsign',
          prop: 'startstopsign',
          dataType: 'SSCODELIST',
        },
        {
          name: 'ouid',
          prop: 'ouid',
          dataType: 'TEXT',
        },
        {
          name: 'shortname',
          prop: 'shortname',
          dataType: 'TEXT',
        },
        {
          name: 'ormorginfoname',
          prop: 'ormorginfoname',
          dataType: 'TEXT',
        },
        {
          name: 'ormorginfo',
          prop: 'ormorginfoid',
        },
      {
        name: 'n_ormorginfoname_like',
        prop: 'n_ormorginfoname_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_orgcode_eq',
        prop: 'n_orgcode_eq',
        dataType: 'TEXT',
      },
      {
        name: 'n_startstopsign_eq',
        prop: 'n_startstopsign_eq',
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