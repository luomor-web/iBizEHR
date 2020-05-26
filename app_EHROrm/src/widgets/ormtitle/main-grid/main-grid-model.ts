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
          name: 'createdate',
          prop: 'createdate',
          dataType: 'DATETIME',
        },
        {
          name: 'titletype',
          prop: 'titletype',
          dataType: 'SSCODELIST',
        },
        {
          name: 'ormtitlename',
          prop: 'ormtitlename',
          dataType: 'TEXT',
        },
        {
          name: 'createman',
          prop: 'createman',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'ormtitlename',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'ormtitleid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'ormtitleid',
          dataType: 'GUID',
        },
        {
          name: 'ormtitle',
          prop: 'ormtitleid',
        },
      {
        name: 'n_ormtitlename_like',
        prop: 'n_ormtitlename_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_titletype_eq',
        prop: 'n_titletype_eq',
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