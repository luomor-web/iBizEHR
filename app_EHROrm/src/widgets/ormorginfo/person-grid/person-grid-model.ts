/**
 * Person 部件模型
 *
 * @export
 * @class PersonModel
 */
export default class PersonModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof PersonGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof PersonGridMode
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
          name: 'srfdataaccaction',
          prop: 'ormorginfoid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
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
          name: 'postinfo',
          prop: 'postinfo',
          dataType: 'SSCODELIST',
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
        name: 'n_postinfo_like',
        prop: 'n_postinfo_like',
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