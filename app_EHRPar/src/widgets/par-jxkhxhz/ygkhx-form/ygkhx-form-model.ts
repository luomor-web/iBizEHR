/**
 * YGKHX 部件模型
 *
 * @export
 * @class YGKHXModel
 */
export default class YGKHXModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof YGKHXModel
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
        prop: 'parjxkhxhzid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'parjxkhxhzname',
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
        name: 'parjxkhxhzname',
        prop: 'parjxkhxhzname',
        dataType: 'TEXT',
      },
      {
        name: 'ygid',
        prop: 'ygid',
        dataType: 'TEXT',
      },
      {
        name: 'xh',
        prop: 'xh',
        dataType: 'INT',
      },
      {
        name: 'khlx',
        prop: 'khlx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'yg',
        prop: 'yg',
        dataType: 'TEXT',
      },
      {
        name: 'zz',
        prop: 'zz',
        dataType: 'TEXT',
      },
      {
        name: 'bm',
        prop: 'bm',
        dataType: 'TEXT',
      },
      {
        name: 'gzjx',
        prop: 'gzjx',
        dataType: 'FLOAT',
      },
      {
        name: 'jswmjc',
        prop: 'jswmjc',
        dataType: 'FLOAT',
      },
      {
        name: 'ywnlks',
        prop: 'ywnlks',
        dataType: 'FLOAT',
      },
      {
        name: 'gznljtd',
        prop: 'gznljtd',
        dataType: 'FLOAT',
      },
      {
        name: 'gznljtd_xbn',
        prop: 'gznljtd_xbn',
        dataType: 'FLOAT',
      },
      {
        name: 'parjxkhxhzid',
        prop: 'parjxkhxhzid',
        dataType: 'GUID',
      },
      {
        name: 'parjxkhxhz',
        prop: 'parjxkhxhzid',
        dataType: 'FONTKEY',
      },
    ]
  }

}