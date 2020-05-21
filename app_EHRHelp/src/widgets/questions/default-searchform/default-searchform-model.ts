/**
 * Default 部件模型
 *
 * @export
 * @class DefaultModel
 */
export default class DefaultModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof DefaultModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'n_ym_like',
        prop: 'ym',
        dataType: 'TEXT',
      },
      {
        name: 'n_questionman_like',
        prop: 'questionman',
        dataType: 'TEXT',
      },
      {
        name: 'n_createdate_gtandeq',
        prop: 'createdate',
        dataType: 'DATETIME',
      },
      {
        name: 'n_createdate_ltandeq',
        prop: 'createdate',
        dataType: 'DATETIME',
      },
      {
        name: 'n_jjcd_eq',
        prop: 'jjcd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_wtzt_eq',
        prop: 'wtzt',
        dataType: 'SSCODELIST',
      },
    ]
  }

}