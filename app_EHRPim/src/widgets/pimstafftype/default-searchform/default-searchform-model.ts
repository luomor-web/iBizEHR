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
        name: 'n_pimstafftypeid_eq',
        prop: 'pimstafftypeid',
        dataType: 'GUID',
      },
      {
        name: 'n_pimstafftypename_like',
        prop: 'pimstafftypename',
        dataType: 'TEXT',
      },
      {
        name: 'pimstafftype',
        prop: 'pimstafftypeid',
        dataType: 'FONTKEY',
      },
    ]
  }

}