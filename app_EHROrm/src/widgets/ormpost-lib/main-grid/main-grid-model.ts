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
          name: 'ormpostlibname',
          prop: 'ormpostlibname',
          dataType: 'TEXT',
        },
        {
          name: 'gwtype_text',
          prop: 'gwtype',
          dataType: 'SSCODELIST',
        },
        {
          name: 'gwflag',
          prop: 'gwflag',
          dataType: 'SSCODELIST',
        },
        {
          name: 'createdate',
          prop: 'createdate',
          dataType: 'DATETIME',
        },
        {
          name: 'isconfidential',
          prop: 'isconfidential',
          dataType: 'SSCODELIST',
        },
        {
          name: 'srfmajortext',
          prop: 'ormpostlibname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'ormpostlibid',
          dataType: 'GUID',
        },
        {
          name: 'mustexcyear',
          prop: 'mustexcyear',
          dataType: 'INT',
        },
        {
          name: 'srfkey',
          prop: 'ormpostlibid',
          dataType: 'GUID',
        },
        {
          name: 'jobdesc',
          prop: 'jobdesc',
          dataType: 'TEXT',
        },
        {
          name: 'gwtype',
          prop: 'gwtype',
          dataType: 'SSCODELIST',
        },
        {
          name: 'sugexcyear',
          prop: 'sugexcyear',
          dataType: 'INT',
        },
        {
          name: 'postnature',
          prop: 'postnature',
          dataType: 'SSCODELIST',
        },
        {
          name: 'createman',
          prop: 'createman',
          dataType: 'TEXT',
        },
        {
          name: 'ormpostlib',
          prop: 'ormpostlibid',
        },
      {
        name: 'n_ormpostlibname_like',
        prop: 'n_ormpostlibname_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_gwtype_eq',
        prop: 'n_gwtype_eq',
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