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
          name: 'awardname',
          prop: 'awardname',
          dataType: 'TEXT',
        },
        {
          name: 'pcmprofileid',
          prop: 'pcmprofileid',
          dataType: 'PICKUP',
        },
        {
          name: 'srfmajortext',
          prop: 'pcmawardswonsname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pcmawardswonsid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pcmawardswonsid',
          dataType: 'GUID',
        },
        {
          name: 'judgeorg',
          prop: 'judgeorg',
          dataType: 'TEXT',
        },
        {
          name: 'awardlevel',
          prop: 'awardlevel',
          dataType: 'SSCODELIST',
        },
        {
          name: 'awardtime',
          prop: 'awardtime',
          dataType: 'DATE',
        },
        {
          name: 'pcmawardswons',
          prop: 'pcmawardswonsid',
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