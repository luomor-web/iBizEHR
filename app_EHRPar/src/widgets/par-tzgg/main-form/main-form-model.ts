/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
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
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'partzggid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'partzggname',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'partzggname',
        prop: 'partzggname',
        dataType: 'TEXT',
      },
      {
        name: 'nd',
        prop: 'nd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'tzlx',
        prop: 'tzlx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'zqlx',
        prop: 'zqlx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'yd',
        prop: 'yd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'jzsj',
        prop: 'jzsj',
        dataType: 'DATE',
      },
      {
        name: 'lhzbmb',
        prop: 'lhzbmb',
        dataType: 'TEXT',
      },
      {
        name: 'partzggid',
        prop: 'partzggid',
        dataType: 'GUID',
      },
      {
        name: 'partzgg',
        prop: 'partzggid',
        dataType: 'FONTKEY',
      },
    ]
  }

}