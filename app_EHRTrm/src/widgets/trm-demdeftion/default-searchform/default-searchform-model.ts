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
        name: 'n_trmdemdeftionname_like',
        prop: 'trmdemdeftionname',
        dataType: 'TEXT',
      },
      {
        name: 'n_pxmk_eq',
        prop: 'pxmk',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_pxkssj_gtandeq',
        prop: 'pxkssj',
        dataType: 'DATE',
      },
      {
        name: 'n_pxjssj_ltandeq',
        prop: 'pxjssj',
        dataType: 'DATE',
      },
    ]
  }

}