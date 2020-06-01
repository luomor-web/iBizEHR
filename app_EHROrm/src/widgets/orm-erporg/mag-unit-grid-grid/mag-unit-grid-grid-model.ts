/**
 * MagUnitGrid 部件模型
 *
 * @export
 * @class MagUnitGridModel
 */
export default class MagUnitGridModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof MagUnitGridGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof MagUnitGridGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'parentorgid',
          prop: 'parentorgid',
          dataType: 'TEXT',
        },
        {
          name: 'orgtypename',
          prop: 'orgtypename',
          dataType: 'TEXT',
        },
        {
          name: 'towncity',
          prop: 'towncity',
          dataType: 'TEXT',
        },
        {
          name: 'ormerporgid',
          prop: 'ormerporgid',
          dataType: 'GUID',
        },
        {
          name: 'yyflag',
          prop: 'yyflag',
          dataType: 'SSCODELIST',
        },
        {
          name: 'srfmajortext',
          prop: 'ormerporgname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'ormerporgid',
          dataType: 'GUID',
        },
        {
          name: 'belongou',
          prop: 'belongou',
          dataType: 'TEXT',
        },
        {
          name: 'oucode',
          prop: 'oucode',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'ormerporgid',
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
          name: 'admcoding',
          prop: 'admcoding',
          dataType: 'TEXT',
        },
        {
          name: 'ormerporgname',
          prop: 'ormerporgname',
          dataType: 'TEXT',
        },
        {
          name: 'ormerporg',
          prop: 'ormerporgid',
        },
      {
        name: 'n_orgcode_like',
        prop: 'n_orgcode_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_ormerporgname_like',
        prop: 'n_ormerporgname_like',
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