/**
 * CurrentQuestions 部件模型
 *
 * @export
 * @class CurrentQuestionsModel
 */
export default class CurrentQuestionsModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof CurrentQuestionsGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof CurrentQuestionsGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'wtzt',
          prop: 'wtzt',
          dataType: 'SSCODELIST',
        },
        {
          name: 'jjcd',
          prop: 'jjcd',
          dataType: 'SSCODELIST',
        },
        {
          name: 'createdate',
          prop: 'createdate',
          dataType: 'DATETIME',
        },
        {
          name: 'questionsid',
          prop: 'questionsid',
          dataType: 'GUID',
        },
        {
          name: 'wtms',
          prop: 'wtms',
          dataType: 'TEXT',
        },
        {
          name: 'questionsname',
          prop: 'questionsname',
          dataType: 'TEXT',
        },
        {
          name: 'createman',
          prop: 'createman',
          dataType: 'TEXT',
        },
        {
          name: 'wtbh',
          prop: 'wtbh',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'questionsname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'questionsid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'questionsid',
          dataType: 'GUID',
        },
        {
          name: 'wcsj',
          prop: 'wcsj',
          dataType: 'DATETIME',
        },
        {
          name: 'pimquestions',
          prop: 'questionsid',
        },
      {
        name: 'n_ym_like',
        prop: 'n_ym_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_questionman_like',
        prop: 'n_questionman_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_createdate_gtandeq',
        prop: 'n_createdate_gtandeq',
        dataType: 'DATETIME',
      },
      {
        name: 'n_createdate_ltandeq',
        prop: 'n_createdate_ltandeq',
        dataType: 'DATETIME',
      },
      {
        name: 'n_jjcd_eq',
        prop: 'n_jjcd_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_wtzt_eq',
        prop: 'n_wtzt_eq',
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